import { Component } from '@angular/core';

@Component({
  selector: 'app-event-binding',
  templateUrl: './event-binding.component.html',
  styles: [
  ]
})
export class EventBindingComponent {
  titre: string = "Event Binding"
  onAfficher(){
    console.log(this.titre);
  }
  onDisplay(val:string){
    console.log(val);
  }
  onKeyPress(event:any){
    console.log(event.key);
  }
}
