import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { AfterViewInit} from '@angular/core';
@Component({
  selector: 'app-filedattente',
  templateUrl: './filedattente.component.html',
  styleUrls: ['./filedattente.component.scss']
})
export class FiledattenteComponent implements OnInit {
  date: any;
  now: any;
  targetDate: any = new Date(2023, 1, 12);
  targetTime: any = this.targetDate.getTime();
  difference!: number;
  months: Array<string> = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
    'July',
    'August',
    'September',
    'October',
    'November',
    'December',
  ];
  currentTime: any = `${
    this.months[this.targetDate.getMonth()]
  } ${this.targetDate.getDate()}, ${this.targetDate.getFullYear()}`;


  @ViewChild('seconds', { static: true })
  seconds!: ElementRef;

  ngAfterViewInit() {
    setInterval(() => {
      this.tickTock();
      this.difference = this.targetTime - this.now;
      this.difference = this.difference / (1000 * 60 * 60 * 24);

      
    }, 1000);
  }

  tickTock() {
    this.date = new Date();
    this.now = this.date.getTime();
    this.seconds.nativeElement.innerText = 60 - this.date.getSeconds();
  }
  constructor() { }

  ngOnInit(): void {
  }

}
