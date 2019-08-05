import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShortUrlListComponent } from './short-url-list/short-url-list.component';
import { ShortUrlDetailsComponent } from './short-url-details/short-url-details.component';
import { CreateShortUrlComponent } from './create-short-url/create-short-url.component';


const routes: Routes = [
  { path: '', redirectTo: 'shortenUrl', pathMatch: 'full' },
  { path: 'shortenUrl', component: CreateShortUrlComponent },
  { path: 'shortUrls', component: ShortUrlListComponent },
  { path: 'details/:code', component: ShortUrlDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
