import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShortUrl } from "../short-url";
import { UrlShortenerService } from "../url-shortener.service";

@Component({
  selector: 'app-create-short-url',
  templateUrl: './create-short-url.component.html',
  styleUrls: ['./create-short-url.component.css']
})
export class CreateShortUrlComponent implements OnInit {

  shortUrl: ShortUrl = new ShortUrl();
  submitted = false;

  constructor(private urlShortenerService: UrlShortenerService,
    private router: Router) { }

  ngOnInit() {
  }

  save() {
    this.urlShortenerService
      .createShortUrl(this.shortUrl)
      .subscribe(data => {
        this.shortUrl = data;
      })
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  goToList() {
    this.router.navigate(['shortUrls'])
  }

}
