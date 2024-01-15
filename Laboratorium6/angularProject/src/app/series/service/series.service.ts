import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Seriess} from "../model/seriess";
import {CharacterDetails} from "../../character/model/character-details";
import {SeriesDetails} from "../model/series-details";
import {Characters} from "../../character/model/characters";
import {CharacterForm} from "../../character/model/character-form";
import {SeriesForm} from "../model/series-form";

/**
 * User management service. Calls REST endpoints.
 */
@Injectable()
export class SeriesService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all series.
   *
   * @return list of series
   */
  getSeriess(): Observable<Seriess> {
    console.log(this.http)
    return this.http.get<Seriess>(`/api/series`);
  }
  getSeries(uuid: string): Observable<SeriesDetails> {
    return this.http.get<SeriesDetails>('/api/series/' + uuid);
  }
  getSeriesCharacters(uuid: string): Observable<Characters> {
    return this.http.get<Characters>('/api/series/' + uuid + '/characters');
  }
  putSeries(uuid: string, request: SeriesForm): Observable<any> {
    return this.http.put('/api/series/' + uuid, request);
  }

  /**
   * Removes single series.
   *
   * @param uuid series id
   */
  deleteSeries(uuid: string): Observable<any> {
    return this.http.delete('/api/series/' + uuid);
  }

}
