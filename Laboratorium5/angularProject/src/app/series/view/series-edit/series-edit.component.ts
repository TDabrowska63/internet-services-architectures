import { Component, OnInit } from '@angular/core';
import { SeriesForm } from '../../model/series-form';
import { SeriesService } from '../../service/series.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-series-edit',
  templateUrl: './series-edit.component.html',
  styleUrl: './series-edit.component.css'
})
export class SeriesEditComponent implements OnInit{
      /**
   * Series's id.
   */
  uuid: string | undefined;

  /**
   * Single series.
   */
  series: SeriesForm | undefined;

  /**
   * Single series.
   */
  original: SeriesForm | undefined;


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
    this.route.params.subscribe(params => {
      this.service.getSeries(params['uuid'])
        .subscribe(series => {
          this.uuid = series.id;
          this.series = {
            seriesName: series.seriesName,
            numberOfSeasons:series.numberOfSeasons
          };
          this.original = {...this.series};
        });
    });
  }

  /**
   * Updates series.
   */
  onSubmit(): void {
    this.service.putSeries(this.uuid!, this.series!)
      .subscribe(() => this.router.navigate(['/seriess']));
  }
}
