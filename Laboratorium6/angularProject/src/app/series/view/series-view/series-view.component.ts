import { Component, OnInit } from '@angular/core';
import { SeriesDetails } from '../../model/series-details';
import { Characters } from '../../../character/model/characters';
import { SeriesService } from '../../service/series.service';
import { CharacterService } from '../../../character/service/character.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Character } from '../../../character/model/character';

@Component({
  selector: 'app-series-view',
  templateUrl: './series-view.component.html',
  styleUrl: './series-view.component.css'
})
export class SeriesViewComponent implements OnInit{
    /**
   * Single series.
   */
  series: SeriesDetails | undefined;
  characters: Characters | undefined;
  /**
   *
   * @param service series service
   * @param route activated route
   * @param router router
   */
  constructor(private service: SeriesService, private characterService: CharacterService,private route: ActivatedRoute, private router: Router) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getSeries(params['uuid']).subscribe(series => this.series = series);
      this.service.getSeriesCharacters(params['uuid']).subscribe(characters => this.characters = characters)
    });
  }
  onDelete(character: Character): void {
    this.characterService.deleteCharacter(character.id).subscribe(() => this.ngOnInit());
  }

}
