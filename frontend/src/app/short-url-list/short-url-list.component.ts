import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { UrlShortenerService } from "../url-shortener.service";
import { ShortUrl } from "../short-url";
import { Router } from "@angular/router";

@Component({
  selector: 'app-short-url-list',
  templateUrl: './short-url-list.component.html',
  styleUrls: ['./short-url-list.component.css']
})
export class ShortUrlListComponent implements OnInit {

  shortUrls: Observable<ShortUrl[]>

  constructor(private urlShortenerService: UrlShortenerService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.shortUrls = this.urlShortenerService.getShortUrlList();
  }

  shortUrlDetails(code: number) {
    this.router.navigate(['details', code]);
  }

}
