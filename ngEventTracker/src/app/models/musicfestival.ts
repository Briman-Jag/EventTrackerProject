export class MusicFestival {

  id: number;
  name: string;
  location: string;
  numOfDays: number;
  startDate: string;
  endDate: string;
  musicGenre: string;
  headliners: string;
  artistsSeen: string;
  ticketPrice: number;

  constructor(id?: number, name?: string, location?: string, numOfDays?: number,
              startDate?: string, endDate?: string, musicGenre?: string, headliners?: string, artistsSeen?: string, ticketPrice?: number) {
      this.id = id;
      this.name = name;
      this.location = location;
      this.numOfDays = numOfDays;
      this.startDate = startDate;
      this.endDate = endDate;
      this.musicGenre = musicGenre;
      this.headliners = headliners;
      this.artistsSeen = artistsSeen;
      this.ticketPrice = ticketPrice;
    }
}

