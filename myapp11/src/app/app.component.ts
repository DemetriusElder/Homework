import { Component } from '@angular/core';
@Component({
selector: 'app-root',
template: `<p [ngStyle]="myStyle">style binding example</p>`,
})
export class AppComponent {
myStyle = {
'font-weight':'bold',
'color':'blue'
}
}
/*Class bindings colors
import { Component } from '@angular/core';
@Component({
selector: 'app-root',
template: `<input type="checkbox" [(ngModel)]="doesNotExercise"
(change)="adjustCSS()"/>Does not exercise.
<input type="checkbox" [(ngModel)]="over55" (change)="adjustCSS()"/>
Is over 55.
<div *ngIf="doesNotExercise || over55" [ngClass]="myClasses" >
Is at risk of heart disease.</div>
`,
styles: [`
.warning {
font-weight:bold;
}
.danger {
color:red;
}
`
]
})
export class AppComponent {
title = 'app';
doesNotExercise = false;
over55 = false;
myClasses = {
warning: false,
danger: true
}
adjustCSS() {
}
}
  /*Yellow and green text changer
import { Component } from '@angular/core';
@Component({
selector: 'app-root',
template: `<label [class.danger]="foodWarning">Has food allergy.</label>
<input type="checkbox" [(ngModel)]="foodWarning" /><br>
<label [class.makemegreen]="greenWarning">Make me green.</label>
<input type="checkbox" [(ngModel)]="greenWarning" />
`,
styles: [`
.danger {
color:orange;
font-weight:bold;
}
.makemegreen{
color:green;
font-weight:bold;
}
`
]
})

export class AppComponent {
foodWarning:Boolean
greenWarning:Boolean
constructor() {
// Set default value to false.
this.foodWarning = false;
this.greenWarning = false;

}
}
*/