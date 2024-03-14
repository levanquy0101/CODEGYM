import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../service/dictionary.service";
import {Dictionary} from "../dictionary";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  words : Dictionary[] = [];

  constructor(private  dictionaryService : DictionaryService, private router: Router) {

  }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(){
    this.words = this.dictionaryService.findAll();
  }

  search(value: string) {
    this.router.navigateByUrl('/detail/' + value).then(r => {
    });
  }
}
