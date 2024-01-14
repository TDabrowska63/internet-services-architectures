import { Component, OnInit } from '@angular/core';
import { Seriess } from '../../model/seriess';
import { SeriesService } from '../../service/series.service';
import { Series } from '../../model/series';

@Component({
  selector: 'app-series-list',
  templateUrl: './series-list.component.html',
  styleUrl: './series-list.component.css'
})
export class SeriesListComponent implements OnInit {

  /**
   * @param service seriess service
   */
  constructor(private service: SeriesService) {
  }

  /**
   * Available seriess.
   */
  seriess: Seriess | undefined;

  ngOnInit(): void {
    this.service.getSeriess().subscribe(seriess => this.seriess = seriess);
  }

  /**
   * Deletes selected series.
   *
   * @param series series to be removed
   */
  onDelete(series: Series): void {
    this.service.deleteSeries(series.id).subscribe(() => this.ngOnInit());
  }
}
