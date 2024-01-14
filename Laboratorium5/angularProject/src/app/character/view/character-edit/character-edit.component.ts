import { Component, OnInit } from '@angular/core';
import { CharacterForm } from '../../model/character-form';
import { Seriess } from '../../../series/model/seriess';
import { CharacterService } from '../../service/character.service';
import { SeriesService } from '../../../series/service/series.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-character-edit',
  templateUrl: './character-edit.component.html',
  styleUrl: './character-edit.component.css'
})
export class CharacterEditComponent implements OnInit {
    /**
   * Character's id.
   */
  uuid: string | undefined;

  /**
   * Single character.
   */
  character: CharacterForm | undefined;

  /**
   * Single character.
   */
  original: CharacterForm | undefined;

  /**
   * Available seriess.
   */
  seriess: Seriess | undefined;

  /**
   * @param characterService character service
   * @param seriesService series service
   * @param route activated route
   * @param router router
   */
  constructor(
    private characterService: CharacterService,
    private seriesService: SeriesService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.seriesService.getSeriess()
        .subscribe(seriess => this.seriess = seriess);

      this.characterService.getCharacter(params['uuid'])
        .subscribe(character => {
          this.uuid = character.id;
          this.character = {
            name: character.name,
            age: character.age,
            series: params['series']
          };
          this.original = {...this.character};
        });
    });
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    this.characterService.putCharacter(this.uuid!, this.character!)
      .subscribe(() => this.router.navigate(['/characters']));
  }

}
