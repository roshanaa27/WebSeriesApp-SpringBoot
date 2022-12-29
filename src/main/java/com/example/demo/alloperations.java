
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class alloperations {
@Autowired repository ob;
@PostMapping("/add")
public String saveSeries(@RequestBody webseries webseries1)
{
	webseries w= new webseries();
	int id=webseries1.getSeriesid();
	String seriesname=webseries1.getSeriesname();
	String season=webseries1.getSeason();
	String episode=webseries1.getEpisode();
	String rating=webseries1.getRating();
	
	w.setSeriesid(id);
	w.setSeriesname(seriesname);
	w.setSeason(season);
	w.setEpisode(episode);
	w.setRating(rating);
	
	webseries first = new webseries(id,seriesname,season,episode,rating);
	ob.save(first);
	return "Items added successfully";
}

@GetMapping("/webseries")
public List<webseries> getAllwebseries()
{
	return ob.findAll();
}

@GetMapping("webseries/{id}")
public List<webseries> getWebSeriesById(@PathVariable("id") int id)
{
	return ob.findById(id);
}

@GetMapping("webseries/name/{seriesname}")
public List<webseries> getWebSeriesByName(@PathVariable("seriesname") String seriesname)
{
	return ob.findByName(seriesname);
}

@PutMapping("/updateseries/{id}")
public String update(@RequestBody webseries x,@PathVariable("id") int id)
{
	int seriesid1=x.getSeriesid();
	String seriesname=x.getSeriesname();
	String season=x.getSeason();
	String episode=x.getEpisode();
	String rating=x.getRating();
	ob.update(seriesid1,seriesname,season,episode,rating,id);
	return "Items successfully updated";
}

@DeleteMapping("delete/{id}")
public String deleteById(@PathVariable("id") int id)
{
	ob.deleteAllByIdInBatch(id);
	return "Items deleted successfully";
}
}
