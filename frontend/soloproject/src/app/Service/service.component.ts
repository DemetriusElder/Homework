import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Champion } from '../Entities/Champion';
import { Observable } from 'rxjs';
import { Url } from '../Entities/Url';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent{
  private champ = 'http://localhost:8080/champion';
  private url = 'http://localhost:8080/url';

  constructor(private http: HttpClient) {}

  
  postUrl(x : Url): Observable<Url> {
    console.log(x);
    return this.http.post<Url>(`${this.url}/post`, x);
  }
  getChampions(): Observable<Champion[]> {
    return this.http.get<Champion[]>(`${this.champ}`);
  }
  getChampionsByWinRate(page: number): Observable<Champion[]> {
    return this.http.get<Champion[]>(`${this.champ}/winrate/${page}`);
  }
  getChampionsByPickRate(page: number): Observable<Champion[]> {
    return this.http.get<Champion[]>(`${this.champ}/pickrate/${page}`);
  }
  getChampionsByName(name: String): Observable<Champion> {
    return this.http.get<Champion>(`${this.champ}/${name}`);
  }
  compareChampions(test: String, test2: String): Observable<Champion> {
    return this.http.get<Champion>(`${this.champ}/compare/${test}/${test2}`);
  }
  getPageChampions(id: number): Observable<Champion[]> {
    return this.http.get<Champion[]>(`${this.champ}/pagelist/${id}`);
  }
}
