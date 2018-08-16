package aglf.service;

import aglf.service.dto.restmapping.matchlineups.MatchLineups;
import aglf.service.dto.restmapping.matchsummary.MatchSummary;
import aglf.service.dto.restmapping.team.TeamProfile;
import aglf.service.dto.restmapping.tournamentschedule.TournamentSchedule;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class RestClient {

    private static final Logger logger = Logger.getLogger(RestClient.class);

    @Value("${api.host}")
    private String API_HOST;
    @Value("${api.key}")
    private String API_KEY;
    @Value("${api.tournament.id}")
    private String API_TOURNAMENT_ID;

    public String get(String urlString) {
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target(urlString);
        Invocation.Builder request = resource.request();
        request.accept(MediaType.APPLICATION_JSON);
        Response response = request.get();
        logger.info("Rest call URL: " + urlString);
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            logger.info("Success! status:" + response.getStatus());
            return response.readEntity(String.class);
        } else {
            logger.error("ERROR! status:" + response.getStatus());
            logger.error("ERROR! status:" + response.readEntity(String.class));
            throw new RuntimeException("Error occurred while contacting API");
        }
    }

    public TournamentSchedule getTournamentSchedule() {
        String result = get(API_HOST + "soccer-t3/as/en/tournaments/" + API_TOURNAMENT_ID + "/schedule.json?api_key=" + API_KEY);
        return new Gson().fromJson(result, TournamentSchedule.class);
    }

    public TeamProfile getTeamProfile(String competitorId) {
        String result = get(API_HOST + "soccer-t3/as/en/teams/" + competitorId + "/profile.json?api_key=" + API_KEY);
        return new Gson().fromJson(result, TeamProfile.class);
    }

    public MatchSummary getMatchSummary(String matchId) {
        // https://api.sportradar.us/soccer-t3/as/en/matches/sr:match:12298056/summary.json?api_key=wv59dfffj5q5shz2k3zctjmt
        String result = get(API_HOST + "soccer-t3/as/en/matches/" + matchId + "/summary.json?api_key=" + API_KEY);
        return new Gson().fromJson(result, MatchSummary.class);
    }

    public MatchLineups getMatchLineups(String matchId) {
        // https://api.sportradar.us/soccer-t3/as/en/matches/sr:match:12298056/lineups.json?api_key=wv59dfffj5q5shz2k3zctjmt
        String result = get(API_HOST + "soccer-t3/as/en/matches/" + matchId + "/lineups.json?api_key=" + API_KEY);
        return new Gson().fromJson(result, MatchLineups.class);
    }

}
