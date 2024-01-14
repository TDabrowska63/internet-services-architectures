import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../../service/character.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Characters } from '../../model/characters';
import { CharacterForm } from '../../model/character-form';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-character-put',
  templateUrl: './character-put.component.html',
  styleUrl: './character-put.component.css'
})
export class CharacterPutComponent implements OnInit{
    /**
   * Single character.
   */
  character: CharacterForm | undefined;
  characters: Characters | undefined;

  /**
   * @param service character service
   * @param route activated route
   * @param router router
   */
  constructor(
    private service: CharacterService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.character = {
        name: "enter name",
        age: 0,
        series: params['uuid']
      };

      this.service.getCharacters().subscribe(characters => this.characters = characters);
    });

    this.service.getCharacters().subscribe(characters => this.characters = characters);
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    let uuid = ""
    let rand:boolean = false
    do {
      uuid = uuidv4()
      rand = false
      for(let i=0; i<this.characters!.characters.length; i++){
        if(uuid==this.characters!.characters[i].id)
        {
          rand = true
        }
      }
    } while (rand)

    this.service.putCharacter(uuid, this.character!)
      .subscribe(() => this.router.navigate(['/seriess/'+this.character!.series]));
  }

}
