import { Series } from "../../series/model/series";

/**
 * Represents single character in list.
 */
export interface CharacterDetails {

  /**
   * Unique id identifying character.
   */
  id: string;

  /**
   * Name of the character.
   */
  name: string;

  age: number;

  series: Series;

}
