import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateShortUrlComponent } from './create-short-url/create-short-url.component';
import { ShortUrlDetailsComponent } from './short-url-details/short-url-details.component';
import { ShortUrlListComponent } from './short-url-list/short-url-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CreateShortUrlComponent,
    ShortUrlDetailsComponent,
    ShortUrlListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
