import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../service/dictionary.service";
import {Dictionary} from "../dictionary";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {find} from "rxjs";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  res: Dictionary = {} as Dictionary;

  constructor(private dictionaryService: DictionaryService, private activatedRoute: ActivatedRoute,) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const word: any = paramMap.get('word');
      this.res = this.dictionaryService.find(word);
    });
  }
}
