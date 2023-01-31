package space.bumtiger.study.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import space.bumtiger.study.domain.Diary;
import space.bumtiger.study.repository.DiaryRepository;

@Repository
public class DiaryRepositoryImpl implements DiaryRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int save(Diary diary) {
		int count = 0;
		String sql = "insert into study.diary(title, content, study_date) "
				+ "values (:title, :content, :study_date)";
		Map<String, String> params = new HashMap<>();
		params.put("title", diary.getTitle());
		params.put("content", diary.getContent());
		params.put("study_date", diary.getStudyDate());
		count = jdbcTemplate.update(sql, params);
		return count;
	}

	@Override
	public List<Diary> listing() {
		String sql = "select * from diary order by study_date desc, sno desc";
		return jdbcTemplate.query(sql, new DiaryMapper());
	}

	private static final class DiaryMapper implements RowMapper<Diary> {

		@Override
		public Diary mapRow(ResultSet rs, int rowNum) throws SQLException {
			Diary diary = new Diary(rs.getInt("sno"), rs.getString("title"),
					rs.getString("content"), rs.getString("study_date"),
					rs.getShort("duration_min"));
			return diary;
		}
	}

	@Override
	public Diary readDiary(String sno) {
		String sql = "select * from diary where sno = :sno";
		Map<String, String> param = new HashMap<>();
		param.put("sno", sno);
		return jdbcTemplate.queryForObject(sql, param, new DiaryMapper());
	}

}
