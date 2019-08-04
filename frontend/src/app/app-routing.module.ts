import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShortUrlListComponent } from './short-url-list/short-url-list.component';
import { ShortUrlDetailsComponent } from './short-url-details/short-url-details.component';


const routes: Routes = [
  { path: '', redirectTo: 'shortUrl', pathMatch: 'full' },
  { path: 'shortUrls', component: ShortUrlListComponent },
  { path: 'details/:code', component: ShortUrlDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
