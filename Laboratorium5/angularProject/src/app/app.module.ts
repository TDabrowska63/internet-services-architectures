import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { SeriesEditComponent } from './series/view/series-edit/series-edit.component';
import { SeriesListComponent } from './series/view/series-list/series-list.component';
import { SeriesPutComponent } from './series/view/series-put/series-put.component';
import { SeriesViewComponent } from './series/view/series-view/series-view.component';
import { CharacterEditComponent } from './character/view/character-edit/character-edit.component';
import { CharacterListComponent } from './character/view/character-list/character-list.component';
import { CharacterPutComponent } from './character/view/character-put/character-put.component';
import { CharacterViewComponent } from './character/view/character-view/character-view.component';
import { CharacterService } from './character/service/character.service';
import { SeriesService } from './series/service/series.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigatorComponent,
    SeriesEditComponent,
    SeriesListComponent,
    SeriesPutComponent,
    SeriesViewComponent,
    CharacterEditComponent,
    CharacterListComponent,
    CharacterPutComponent,
    CharacterViewComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    CharacterService,
    SeriesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
