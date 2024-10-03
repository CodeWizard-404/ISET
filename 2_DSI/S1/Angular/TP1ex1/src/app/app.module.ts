import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './WebSite/header/header.component';
import { ContentComponent } from './WebSite/content/content.component';
import { FooterComponent } from './WebSite/footer/footer.component';
import { BasesComponent } from './WebSite/content/bases/bases.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ContentComponent,
    FooterComponent,
    BasesComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
