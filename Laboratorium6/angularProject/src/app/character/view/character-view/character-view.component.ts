import { Component, OnInit } from '@angular/core';
import { CharacterDetails } from '../../model/character-details';
import { CharacterService } from '../../service/character.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-character-view',
  templateUrl: './character-view.component.html',
  styleUrl: './character-view.component.css'
})
export class CharacterViewComponent implements OnInit{
    /**s
   * Single character.
   */
  character: CharacterDetails | undefined;

  /**
   *
   * @param service character service
   * @param route activated route
   * @param router router
   */
  constructor(private service: CharacterService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getCharacter(params['uuid'])
        .subscribe(character => this.character = character)
    });
  }
}
