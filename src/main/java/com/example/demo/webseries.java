
package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class webseries {
@Id 
@GeneratedValue(strategy=GenerationType.AUTO)

private int id;
private int seriesid;
private String seriesname;
private String season;
private String episode;
private String rating;

webseries() {}

webseries(int seriesid,String seriesname, String season, String episode, String rating)
{
	this.setSeriesid(seriesid);
	this.setSeriesname(seriesname);
	this.setSeason(season);
	this.setEpisode(episode);
	this.setRating(rating);
}
public int getSeriesid()
{
	return seriesid;
}
public void setSeriesid(int seriesid)
{
	this.seriesid=seriesid;
}
public String getSeriesname()
{
	return seriesname;
}
public void setSeriesname(String seriesname)
{
	this.seriesname=seriesname;
}
public String getSeason()
{
	return season;
}
public void setSeason(String season)
{
	this.season=season;
}
public String getEpisode()
{
	return episode;
}
public void setEpisode(String episode)
{
	this.episode=episode;
}
public String getRating()
{
	return rating;
}
public void setRating(String rating)
{
	this.rating=rating;
}
}
