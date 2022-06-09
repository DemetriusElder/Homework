import { Component } from '@angular/core';
@Component({
selector: 'app-root',
templateUrl: './app.component.html',
styleUrls: ['./app.component.css']
})
export class AppComponent {
title = 'app';
}
/*Accesses position of mouse once they click
import { Component } from '@angular/core';
@Component({
selector: 'app-root',
templateUrl: './app.component.html',
styleUrls: ['./app.component.css']
})
export class AppComponent {
title = 'app';
myMouseHandler(event: { screenX: { toString: () => string; }; screenY: { toString: () => string; }; }, description: string) {
console.log(description + " X: "
+ event.screenX.toString()
+ " Y:" + event.screenY.toString())
}
}
can save what is cut and poaste and copy
import { Component } from '@angular/core';
@Component({
selector: 'app-root',
templateUrl: './app.component.html',
styleUrls: ['./app.component.css']
})
export class AppComponent {
title = 'app';
cutContent = '';
myContent?: string;
myPastedContent?: string;
cutEvent(content: any) {
this.cutContent = content;
console.log(content)
}
pasteContent() {
console.log(this.cutContent);
this.cutContent = '';
}
}
in and out of focus (When i click in and otu of the box)
import { Component } from '@angular/core';
@Component({
selector: 'app-root',
templateUrl: './app.component.html',
styleUrls: ['./app.component.css']
})
export class AppComponent {
title = 'app';
myFocusEvent(description: any) {
console.log(description)
}
}
Key Logging
import { Component } from '@angular/core';
@Component({
selector: 'app-root',
templateUrl: './app.component.html',
styleUrls: [ './app.component.css']
})
export class AppComponent {
title = 'app';
myKeyDown(event: { key: any; }) {
console.log(event)
console.log(event.key)
}
myKeyUp(event: { key: any; }) {
  console.log(event)
  console.log(event.key)
  }
}
Mouse Logging
import { Component } from '@angular/core';
@Component({
selector: 'app-root',
templateUrl: './app.component.html',
styleUrls: ['./app.component.css']
})
export class AppComponent {
title = 'app';
myMouseEnter() {
console.log("Mouse entered!")
}
}
/* This whole ting is for parent class
import { Component } from '@angular/core';
// This component consumes the re-usable service.
@Component({
selector: 'app-root',
template: `
<h3>Please enter the customer informatino:</h3>
<child [callParent]="parentFuncRef" [city]="op"></child>
{{dataFromChild}}
`
})
export class AppComponent {
parentFuncRef?: Function;
operations?: Array<any>;
dataFromChild?: string;
op?: string;
// This function is called by the Angular framework after
// the constructor executes.
public ngOnInit() {
this.parentFuncRef = this.myCallBackFunction.bind(this);
}
// This function can be called by child.
public myCallBackFunction(streetAddress: string, city: string, region: string) {
this.dataFromChild =
"Street Address: " + streetAddress + " " + "Region: " + region+ " "+
"City: " + city;
}
}*/