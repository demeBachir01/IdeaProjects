import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-enseignant',
  templateUrl: './enseignant.component.html',
  styleUrls: ['./enseignant.component.css']
})
export class EnseignantComponent implements OnInit {
  coursEn! : Array<any>

  constructor(){}
  ngOnInit(): void {
    this.coursEn=[
      {id:1, name:"DBA",enseignant:"Mr Kasse",responsable: "Alpha Ba",heure:"12/4/2021"},
      {id:2, name:"RESEAU",enseignant:"Mr Ngom",responsable: "Mariama Balde",heure:"15/4/2021"},
      {id:3, name:"SE",enseignant:"Mr Gaye",responsable: "Moussa Ndiaye",heure:"21/4/2021"},
      {id:4, name:"UML",enseignant:"Mr Sall",responsable: "Modou Fall",heure:"2/5/2021"},
      {id:5, name:"java",enseignant:"Mr Ka",responsable: "Pape Abdou Mbaye",heure:"7/5/2021"},

    ]
    throw new Error('Method not implemented.');

  }

}
