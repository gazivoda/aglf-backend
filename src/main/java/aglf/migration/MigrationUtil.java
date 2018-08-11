package aglf.migration;

import aglf.data.dao.TeamDao;
import aglf.data.model.Team;
import aglf.service.RestClient;
import aglf.service.dto.restmapping.team.Player;
import aglf.service.dto.restmapping.team.TeamProfile;
import aglf.service.dto.restmapping.tournamentschedule.TournamentSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class MigrationUtil {

    @Value("#{'${competitors.list}'.split(',')}")
    private List<String> COMPETITORS_LIST;

    @Autowired
    private RestClient restClient;
    @Autowired
    private TeamDao teamDao;

    public void importTeams() {
        for (String competitorId : COMPETITORS_LIST) {
            // sleep to cool off rest
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TeamProfile teamProfile = restClient.getTeamProfile(competitorId);
            Team team = new Team();
            team.setExternalId(teamProfile.getTeam().getId());
            team.setName(teamProfile.getTeam().getName());
            team.setAbbreviation(teamProfile.getTeam().getAbbreviation());
            team.setCapacity(teamProfile.getVenue().getCapacity());
            team.setCity(teamProfile.getVenue().getCity_name());
            if (teamProfile.getManager() != null) {
                team.setManagerName(teamProfile.getManager().getName());
            }
            for (Player playerInfo : teamProfile.getPlayers()) {
                aglf.data.model.Player player = new aglf.data.model.Player();
                player.setTeam(team);
                player.setExternalId(playerInfo.getId());
                player.setFirstName(playerInfo.getName().split(",")[0].trim());
                if (playerInfo.getName().split(",").length > 1) {
                    player.setLastName(playerInfo.getName().split(",")[1].trim());
                }
                player.setNumber(playerInfo.getJersey_number() != null ? playerInfo.getJersey_number() : 999);
                player.setDateOfBirth(playerInfo.getDate_of_birth());
                if (playerInfo.getType() != null) {
                    switch (playerInfo.getType()) {
                        case "defender":
                            player.setPosition(aglf.data.model.Player.Position.DEFENDER);
                            break;
                        case "midfielder":
                            player.setPosition(aglf.data.model.Player.Position.MIDFILDER);
                            break;
                        case "forward":
                            player.setPosition(aglf.data.model.Player.Position.STRIKER);
                            break;
                        case "goalkeeper":
                            player.setPosition(aglf.data.model.Player.Position.GOALKEEPER);
                            break;
                    }
                }
                player.setPrice(new Random().nextInt(101));
                team.getPlayers().add(player);
            }
            teamDao.save(team);
        }


    }

    public void importMatchSchedule() {
        TournamentSchedule tournamentSchedule = restClient.getTournamentSchedule();
        System.out.println(tournamentSchedule);
    }

}
