package lt.msi2015.leaderboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.points_transfer_info.PointsTransferInfo;
import lt.msi2015.points_transfer_info.PointsTransferInfoRepository;

@Service
public class LeaderboardService {
	
	@Autowired
	PointsTransferInfoRepository pointTransfers;
	
	@Transactional
	List<LeaderboardEntryDto> getLeaderboardEntries() {
		Iterable<PointsTransferInfo> transfers = pointTransfers.findAll();
		Map<String, LeaderboardEntryDto> map = new HashMap<String, LeaderboardEntryDto>();
		Iterator<PointsTransferInfo> i = transfers.iterator();
		
		while (i.hasNext()) {
			PointsTransferInfo t = i.next();
			String key = t.toUser;
			if (map.get(key) == null)
				map.put(key, new LeaderboardEntryDto(key, t.points));
			else
				map.get(key).points += t.points;
		}
		return new ArrayList<LeaderboardEntryDto>(map.values());
	}

}
