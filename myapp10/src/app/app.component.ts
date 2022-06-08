import { Component } from '@angular/core';

//Sorry about mess i want to be able to reference this in future so I kept all the examples.

export class PlayingCard {
  cardVal?: string;
  suit?: string;
}
@Component({
  selector: 'app-root',
  template: `
    <!-- Simple display variables messages. -->
    <h1>Hello world! {{title}}. My last name is {{lastName}}! <br/>
  {{card.cardVal}} of {{card.suit}}.<br/>
  {{card1.cardVal}} of {{card1.suit}}.</h1>
  <!-- Two way variable binding. Lets us change the field variable in real time. -->
  Card Number: <input [(ngModel)]="card.cardVal">
  Card Suit: <input [(ngModel)]="card.suit">
  <input [(ngModel)]="myinput">
  <input type='button' (click)=doSomething(myinput)>
  {{myoutput}}
  <!-- Show cards in unordered list. -->
  <ul><li *ngFor="let card of cards" (click)="onSelect(card)">
  {{card.cardVal}}</li>
  </ul>
  <div *ngIf="selectedCard">
  <h2>{{selectedCard.cardVal}} **</h2>
  <input [(ngModel)]="selectedCard.cardVal" placeholder="name"/>
  </div>
  <!-- Submission forms with invalid entries messages. -->
  <section>
  <form #myForm="ngForm">
  Name:
  <input type="text" pattern="[a-zA-Z ]*" minlength="3" required
  [(ngModel)]="myName" name="firstName" #firstName="ngModel" >
  <div [hidden]="firstName.valid || firstName.pristine">
  This control is invalid.</div>
  <p *ngIf="firstName?.errors?.['required']">This field is required.</p>
  <p *ngIf="firstName?.errors?.['pattern']">
  Only alphabetical characters are allowed.</p>
  <p *ngIf="firstName?.errors?.['minlength']">
  This entry must have at least three characters.</p>
  <button type="submit" class="btn btn-default"
  [disabled]="!myForm.form.valid" (click)="onSubmit()">Submit</button><br>
  LastName:
  <input type="text" pattern="[a-zA-Z ]*" minlength="2" required
  [(ngModel)]="myLastName" name="LastName" #LastName="ngModel" >
  <div [hidden]="LastName.valid || LastName.pristine">
  This control is invalid.</div>
  <p *ngIf="LastName?.errors?.['required']">This field is required.</p>
  <p *ngIf="LastName?.errors?.['pattern']">
  Only alphabetical characters are allowed.</p>
  <p *ngIf="LastName?.errors?.['minlength']">
  This entry must have at least three characters.</p>
  <button type="submit" class="btn btn-default"
  [disabled]="!myForm.form.valid" (click)="onSubmit()">Submit</button>

  </form>
  </section>`
})
//Variables and functions referenced
export class AppComponent {
  myinput = '';
  myoutput = '';
  myName?: string;
  myLastName?: string;
  constructor() {
    this.myName = "frank";
    this.myLastName = ""
  }
  onSubmit() {
    //Alert is the popup box
    alert(this.myName);
    alert(this.myLastName);
  }
  doSomething(someContent: string) {
    alert(someContent);
    this.myoutput = someContent;
  }
  title = 'myapp10';
  lastName = 'Elder';
  card: PlayingCard = {
    cardVal: "Ace",
    suit: "Spades"
    };
    card1: PlayingCard = {
      cardVal: "Queen",
      suit: "Diamonds"
    };
    cards:PlayingCard[] = [
      { cardVal:"Ace", suit:"Spades"},
      { cardVal:"Two", suit:"Clubs" },
      { cardVal:"Six", suit:"Hearts"},
      ];
    selectedCard?: PlayingCard;
    onSelect(card: PlayingCard) {
      alert(card.suit);
      this.selectedCard = card;
      }
}
