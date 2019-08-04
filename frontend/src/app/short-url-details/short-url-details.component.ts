import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ShortUrl } from "../short-url";
import { UrlShortenerService } from "../url-shortener.service";

@Component({
  selector: 'app-short-url-details',
  templateUrl: './short-url-details.component.html',
  styleUrls: ['./short-url-details.component.css']
})
export class ShortUrlDetailsComponent implements OnInit {

  code: number;
  shortUrl: ShortUrl;

  constructor(private route: ActivatedRoute,
    private urlShortenerService: UrlShortenerService,
    private router: Router) { }

  ngOnInit() {
    this.shortUrl = new ShortUrl();
    this.code = this.route.snapshot.params['code'];

    this.urlShortenerService.getShortUrlDetails(this.code)
      .subscribe(data => {
        this.shortUrl = data;
      })
  }

}
