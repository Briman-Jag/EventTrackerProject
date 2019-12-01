package com.skilldistillery.eventtracker.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MusicFestival {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String location;
	
	@Column(name = "number_of_days")
	private int numOfDays;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "music_genre")
	private String musicGenre;
	
	private String headliners;
	
	@Column(name = "music_artists_seen")
	private String artistsSeen;
	
	@Column(name = "ticket_price")
	private double ticketPrice;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMusicGenre() {
		return musicGenre;
	}

	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}

	public String getHeadliners() {
		return headliners;
	}

	public void setHeadliners(String headliners) {
		this.headliners = headliners;
	}

	public String getArtistsSeen() {
		return artistsSeen;
	}

	public void setArtistsSeen(String artistsSeen) {
		this.artistsSeen = artistsSeen;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistsSeen == null) ? 0 : artistsSeen.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((headliners == null) ? 0 : headliners.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((musicGenre == null) ? 0 : musicGenre.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numOfDays;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ticketPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicFestival other = (MusicFestival) obj;
		if (artistsSeen == null) {
			if (other.artistsSeen != null)
				return false;
		} else if (!artistsSeen.equals(other.artistsSeen))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (headliners == null) {
			if (other.headliners != null)
				return false;
		} else if (!headliners.equals(other.headliners))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (musicGenre == null) {
			if (other.musicGenre != null)
				return false;
		} else if (!musicGenre.equals(other.musicGenre))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numOfDays != other.numOfDays)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (Double.doubleToLongBits(ticketPrice) != Double.doubleToLongBits(other.ticketPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MusicFestival [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", location=");
		builder.append(location);
		builder.append(", numOfDays=");
		builder.append(numOfDays);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", musicGenre=");
		builder.append(musicGenre);
		builder.append(", headliners=");
		builder.append(headliners);
		builder.append(", artistsSeen=");
		builder.append(artistsSeen);
		builder.append(", ticketPrice=");
		builder.append(ticketPrice);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
