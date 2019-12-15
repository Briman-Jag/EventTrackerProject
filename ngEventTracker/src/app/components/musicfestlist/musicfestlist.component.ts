import { MusicfestService } from './../../services/musicfest.service';
import { MusicFestival } from './../../models/musicfestival';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-musicfestlist',
  templateUrl: './musicfestlist.component.html',
  styleUrls: ['./musicfestlist.component.css']
})
export class MusicfestlistComponent implements OnInit {

  // Fields
  urlId: number = null;

  selectedMusicFest = null;

  musicFests: MusicFestival[] = [];

  selectedGenre = 'all';

  newMusicFest: MusicFestival = new MusicFestival();

  editMusicFest: MusicFestival = null;

  createMusicFestForm = null;


  // Constructor
  constructor(private musicFestSvc: MusicfestService, private currentRoute: ActivatedRoute) { }


  // Functions

  ngOnInit() {

    this.loadMusicFestivalList();

    this.musicFestSvc.index().subscribe(
      data => {
        this.musicFests = data;
        if (this.currentRoute.snapshot.paramMap.get('id')) {
          this.urlId = +this.currentRoute.snapshot.paramMap.get('id');
          this.musicFests.forEach((d) => {
            if (d.id === this.urlId) {
            this.selectedMusicFest = d;
            }
          });
        }
      },
      err => console.error('Reload error in Component')
    );
  }

  loadMusicFestivalList() {
    this.musicFestSvc.index().subscribe(
      data => {
        this.musicFests = data;
      },
      err => {
        console.error(err);
        console.error('MusicfestivalListComponent.loadMusicFestivalList(): error loading music festivals');
      }
    );
  }

  displayMusicFest(musicfestival) {
    this.selectedMusicFest = musicfestival;
  }

  addMusicFestival(newMusicFest: MusicFestival) {

    this.musicFestSvc.create(this.newMusicFest).subscribe(
      data => {
        this.loadMusicFestivalList();
        this.newMusicFest = new MusicFestival();

      },
      err => {
        console.error(err);
        console.error('MusicFestivalComponent.addMusicFestival(): error adding music festival');
      }
    );
    this.newMusicFest = new MusicFestival();

  }

  setEditMusicFestival() {
    this.editMusicFest = Object.assign({}, this.selectedMusicFest);
  }

  updateMusicFest(musicFest: MusicFestival) {

    this.musicFestSvc.update(musicFest).subscribe(
      data => {
        this.loadMusicFestivalList();
        this.editMusicFest = null;
        this.selectedMusicFest = null;
      },
      err => {
        console.error(err);
        console.error('MusicfestivalListComponent.loadTodoList(): error loading Music Festivals');
      }
    );
  }

  deleteMusicFest(id: number) {
    this.musicFestSvc.delete(id).subscribe(
      good => {
        this.loadMusicFestivalList();
      },
      bad => {
        console.error('MusicfestivalComponent.deleteMusicFest(): error deleting Music Festivals');
        console.error(bad);
      }
    );
  }

}
