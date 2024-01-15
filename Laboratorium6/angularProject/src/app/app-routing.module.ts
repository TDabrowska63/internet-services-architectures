import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SeriesListComponent } from './series/view/series-list/series-list.component';
import { SeriesEditComponent } from './series/view/series-edit/series-edit.component';
import { SeriesPutComponent } from './series/view/series-put/series-put.component';
import { SeriesViewComponent } from './series/view/series-view/series-view.component';
import { CharacterPutComponent } from './character/view/character-put/character-put.component';
import { CharacterListComponent } from './character/view/character-list/character-list.component';
import { CharacterViewComponent } from './character/view/character-view/character-view.component';
import { CharacterEditComponent } from './character/view/character-edit/character-edit.component';

const routes: Routes = [
  {
    component: CharacterPutComponent,
    path: "seriess/:uuid/characters/create"
  },
  {
    component: SeriesListComponent,
    path: "seriess"
  },
  {
    component: CharacterListComponent,
    path: "characters"
  },
  {
    component: CharacterViewComponent,
    path: "seriess/:series/characters/:uuid"
  }
  ,
  {
    component: CharacterEditComponent,
    path: "seriess/:series/characters/:uuid/edit"
  },
  {
    component: SeriesEditComponent,
    path: "seriess/:uuid/edit"
  },
  {
    component: SeriesPutComponent,
    path: "seriess/create"
  },
  {
    component: SeriesViewComponent,
    path: "seriess/:uuid"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
