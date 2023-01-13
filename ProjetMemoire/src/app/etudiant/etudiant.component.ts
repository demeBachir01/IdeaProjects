import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.css']
})
export class EtudiantComponent implements OnInit {
  cours! : Array<any>
  constructor (){};
  ngOnInit(): void {
    this.cours=[
      {id:1, name:"DBA",enseignant:"Mr Kasse"},
      {id:2, name:"RESEAU",enseignant:"Mr Ngom"},
      {id:3, name:"SE",enseignant:"Mr Gaye"},
      {id:4, name:"UML",enseignant:"Mr Sall"},
      {id:5, name:"java",enseignant:"Mr Ka"},

    ]
    throw new Error('Method not implemented.');
  }

}
