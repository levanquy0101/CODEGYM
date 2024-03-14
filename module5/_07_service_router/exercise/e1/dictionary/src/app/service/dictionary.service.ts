import { Injectable } from '@angular/core';
import {Dictionary} from "../dictionary";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  words : Dictionary[] = [
    {
      word: "hello",
      mean: "xin chao"
    },
    {
      word: "world",
      mean: "the gioi"
    },
    {
      word: "computer",
      mean: "may tinh"
    }
  ]


  constructor() { }

  findAll(){
    return this.words;
  }

  find(word: string) : any{
    return this.words.find(e => {
      return  e.word == word;
    })
  }
}
