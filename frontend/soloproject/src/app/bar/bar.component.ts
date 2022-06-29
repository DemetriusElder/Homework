import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Champion } from '../Entities/Champion';
import { Url } from '../Entities/Url';
import { ServiceComponent } from '../Service/service.component';

@Component({
  selector: 'app-bar',
  templateUrl: './bar.component.html',
  styleUrls: ['./bar.component.css']
})
export class BarComponent implements OnInit {

  champions: Champion[] = [];
  champ!: Champion;
  champ2!: Champion;
  winner!: Champion;
  name1: String = 'Ivern';
  name2: String = 'Tryndamere';
  url: Url = {
    tinyurl: 'Section 1',
    realurl: '12345678',
    id: 100
  }
  constructor(private route: ActivatedRoute,
    private router: Router,
    private service: ServiceComponent) {
  }

  ngOnInit(): void {
    console.log(this.url.id)
    console.log(this.url.realurl)
    console.log(this.url.tinyurl)
   this.postUrl();
  }

  postUrl(){
    this.service.postUrl(this.url).subscribe((champs) => {this.url = champs;
      console.log(this.url);});
  }
  getChampions(){
    this.service.getChampions()
    .subscribe((champs) => {this.champions = champs;
      console.log(this.champions);});
  }
  getChampionsByWinRate(){
    this.service.getChampionsByWinRate(1)
    .subscribe((champs) => {this.champions = champs;
      console.log(this.champions);});
 }
  getChampionsByPickRate(){
    this.service.getChampionsByPickRate(1)
    .subscribe((champs) => {this.champions = champs;
      console.log(this.champions);});
 }
  getChampionsById(){
    this.service.getChampionsByName(this.name2)
    .subscribe((champs) => {this.champ = champs;
      console.log(this.champ);});
 }
 getChampions2ById(){
  this.service.getChampionsByName(this.name1)
  .subscribe((champs) => {this.champ2 = champs;
    console.log(this.champ2);});
}
compareChampions(){
    this.service.compareChampions(this.name1, this.name2)
    .subscribe((champs) => {this.winner = champs;
      console.log(this.winner);});
 }
    
getPageChampions(){
  this.service.getPageChampions(1)
    .subscribe((champs) => {this.champions = champs;
      console.log(this.champions);});
}

}
