import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  date:Date = new Date();
  currentDate: string = '';
  month:number = this.date.getMonth()+1;
  day:number = this.date.getDate();
  year:number = this.date.getFullYear();


  constructor() { }

  ngOnInit(): void {
    this.currentDate = this.day + '/' + this.month + '/' + this.year;
  }

}
