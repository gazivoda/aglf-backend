package aglf.service;

import aglf.data.dao.MatchDao;
import aglf.data.model.Match;
import aglf.service.dto.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MatchService {

    @Autowired
    private MatchDao matchDao;

    public List<MatchDto> getAll() {
        List<Match> matchList = matchDao.findAll();
        List<MatchDto> matchDtos = new ArrayList<>();
        for (Match match : matchList) {
            MatchDto dto = new MatchDto();
            dto.setId(match.getId());
            dto.setHomeTeam(match.getHomeTeam().getName());
            dto.setHomeTeamId(match.getHomeTeam().getId());
            dto.setHomeTeamScore(match.getHomeTeamScore());
            dto.setAwayTeam(match.getGuestTeam().getName());
            dto.setAwayTeamId(match.getGuestTeam().getId());
            dto.setAwayTeamScore(match.getGuestTeamScore());
            dto.setMatchTime(match.getMatchTime());
            dto.setRound(match.getRound());
            matchDtos.add(dto);
        }
        return matchDtos;
    }
}
