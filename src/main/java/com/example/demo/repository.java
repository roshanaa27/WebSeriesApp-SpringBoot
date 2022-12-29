
package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface repository extends JpaRepository<webseries,Integer>{

	@Query(value="SELECT * FROM webseries s where s.seriesid=?1",nativeQuery=true)
	List<webseries> findById(int id);
	
	
	@Query(value="SELECT * FROM webseries s where s.seriesname=?1",nativeQuery=true)
	List<webseries> findByName(String seriesname);
	
	
	@Modifying
	@Transactional
	@Query(value="Update webseries s set s.seriesid=?1 , s.seriesname=?2 , s.season=?3 , s.episode=?4 , s.rating=?5 where s.seriesid=?6", nativeQuery=true)
	void update(int seriesid,String seriesname, String season, String episode, String rating,int id);
	
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM webseries where seriesid=?1", nativeQuery=true)
	void deleteAllByIdInBatch(int id);
}
