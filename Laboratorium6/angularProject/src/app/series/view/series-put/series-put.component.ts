import { Component, OnInit } from '@angular/core';
import { SeriesForm } from '../../model/series-form';
import { Seriess } from '../../model/seriess';
import { SeriesService } from '../../service/series.service';
import { ActivatedRoute, Router } from '@angular/router';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-series-put',
  templateUrl: './series-put.component.html',
  styleUrl: './series-put.component.css'
})
export class SeriesPutComponent implements OnInit{
    
  /**
   * Single series.
   */
  series: SeriesForm | undefined;
  seriess: Seriess | undefined;

  /**
   * @param service series service
   * @param route activated route
   * @param router router
   */
  constructor(
    private service: SeriesService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.series = {
      seriesName: "enter name",
      numberOfSeasons: 0
    }
    this.service.getSeriess().subscribe(seriess => this.seriess = seriess)
  }

  /**
   * Updates series.
   */
  onSubmit(): void {
    let uuid = ""
    let rand:boolean = false
    do {
       uuid = uuidv4()
       rand = false
       for(let i=0; i<this.seriess!.seriess.length; i++){
         if(uuid==this.seriess!.seriess[i].id)
         {
           rand = true
         }
       }
     }while (rand)

     this.service.putSeries(uuid, this.series!)
       .subscribe(() => this.router.navigate(['/seriess']));
  }

}
