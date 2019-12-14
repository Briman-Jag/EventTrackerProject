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
        console.error('TodoListComponent.loadTodoList(): error loading todos');
      }
    );
  }
}
