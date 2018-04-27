package com.jfoltyn.forsetiserver.generator;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.random;

class ConstantsRepository {
   static List<String> femaleNames() {
      return Arrays.asList(
            "Maria",
            "Krystyna",
            "Anna",
            "Barbara",
            "Teresa",
            "Elżbieta",
            "Janina",
            "Zofia",
            "Jadwiga",
            "Danuta",
            "Halina",
            "Irena",
            "Ewa",
            "Małgorzata",
            "Helena",
            "Grażyna",
            "Bożena",
            "Stanisława",
            "Jolanta",
            "Marianna",
            "Urszula",
            "Wanda",
            "Alicja",
            "Dorota",
            "Agnieszka",
            "Beata",
            "Katarzyna",
            "Joanna",
            "Wiesława",
            "Renata"
      );
   }

   static List<String> femaleSurnames() {
      return Arrays.asList(
            "Nowak",
            "Kowalska",
            "Wiśniewska",
            "Wójcik",
            "Kowalczyk",
            "Kamińska",
            "Lewandowska",
            "Zielińska",
            "Szymańska",
            "Woźniak",
            "Dąbrowska",
            "Kozłowska",
            "Jankowska",
            "Wojciechowska",
            "Kwiatkowska",
            "Mazur",
            "Krawczyk",
            "Kaczmarek",
            "Piotrowska",
            "Grabowska",
            "Pawłowska",
            "Michalska",
            "Zając",
            "Król",
            "Jabłońska",
            "Wieczorek",
            "Nowakowska",
            "Wróbel",
            "Majewska",
            "Stępień",
            "Olszewska",
            "Jaworska",
            "Malinowska",
            "Adamczyk",
            "Górska",
            "Nowicka",
            "Pawlak",
            "Dudek",
            "Witkowska",
            "Walczak",
            "Rutkowska",
            "Sikora",
            "Michalak",
            "Szewczyk",
            "Ostrowska",
            "Baran",
            "Tomaszewska",
            "Pietrzak",
            "Wróblewska",
            "Marciniak"
      );
   }


   static List<String> maleNames() {
      return Arrays.asList(
            "Jan",
            "Stanisław",
            "Andrzej",
            "Józef",
            "Tadeusz",
            "Jerzy",
            "Zbigniew",
            "Krzysztof",
            "Henryk",
            "Ryszard",
            "Kazimierz",
            "Marek",
            "Marian",
            "Piotr",
            "Janusz",
            "Władysław",
            "Adam",
            "Wiesław",
            "Zdzisław",
            "Edward",
            "Mieczysław",
            "Roman",
            "Mirosław",
            "Grzegorz",
            "Czesław",
            "Dariusz",
            "Wojciech",
            "Jacek",
            "Eugeniusz",
            "Tomasz"
      );
   }

   static List<String> maleSurnames() {
      return Arrays.asList(
            "Nowak",
            "Kowalski",
            "Wiśniewski",
            "Wójcik",
            "Kowalczyk",
            "Kamiński",
            "Lewandowski",
            "Zieliński",
            "Woźniak",
            "Szymański",
            "Dąbrowski",
            "Kozłowski",
            "Jankowski",
            "Mazur",
            "Wojciechowski",
            "Kwiatkowski",
            "Krawczyk",
            "Kaczmarek",
            "Piotrowski",
            "Grabowski",
            "Zając",
            "Król",
            "Pawłowski",
            "Michalski",
            "Wróbel",
            "Jabłoński",
            "Wieczorek",
            "Nowakowski",
            "Majewski",
            "Olszewski",
            "Stępień",
            "Jaworski",
            "Dudek",
            "Adamczyk",
            "Malinowski",
            "Pawlak",
            "Górski",
            "Sikora",
            "Nowicki",
            "Witkowski",
            "Walczak",
            "Baran",
            "Rutkowski",
            "Michalak",
            "Szewczyk",
            "Ostrowski",
            "Tomaszewski",
            "Zalewski",
            "Wróblewski",
            "Pietrzak"
      );
   }


   static String loremIpsum() {
      return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam velit velit, consequat nec fermentum vitae, iaculis in orci. Nulla facilisi. Aenean pretium ex nunc, quis interdum elit feugiat vel. Duis a magna nulla. Pellentesque ultrices, elit ut gravida porta, ipsum ex feugiat nibh, in semper ipsum massa condimentum neque. Etiam sit amet lectus in augue fermentum blandit in vitae nisl. Integer elementum sed ante sed tristique. Vivamus sapien justo, sodales sit amet condimentum id, mattis sit amet tellus.\n" +
            "Cras cursus maximus vulputate. Sed vehicula molestie est, vel molestie diam euismod sed. Quisque vehicula massa tincidunt tortor interdum, vel posuere magna sollicitudin. Quisque ligula urna, molestie id turpis a, mollis molestie mi. Pellentesque semper, metus quis semper condimentum, lorem massa ullamcorper enim, imperdiet tempor nisl lorem et augue. Pellentesque quis efficitur velit, non vulputate enim. Nullam facilisis diam eu magna vestibulum, eget laoreet purus semper. Praesent vel est et velit molestie viverra ac quis sapien. Praesent id auctor lacus. Phasellus ac sagittis diam. Vivamus luctus suscipit erat, eget sagittis magna vehicula nec. Sed gravida ante elit, sit amet aliquet nibh ultricies sed. Duis feugiat facilisis euismod. Phasellus commodo placerat fringilla. Integer arcu dui, mattis id hendrerit eu, imperdiet vel dolor. Proin dapibus nunc ut laoreet porttitor.\n" +
            "Phasellus consectetur turpis sit amet ex tincidunt, sed aliquam nunc consectetur. Vestibulum ultrices ex blandit dictum suscipit. Cras sed fringilla ex. Donec ligula quam, accumsan quis venenatis nec, eleifend nec enim. Morbi in efficitur odio, mollis lobortis tortor. Proin efficitur lacus magna, a accumsan massa consectetur accumsan. Curabitur sodales nibh nec accumsan vestibulum.\n" +
            "Pellentesque semper libero et augue tempus, sit amet commodo felis tempor. Phasellus id lorem ex. Praesent laoreet tellus quis elit finibus, id rutrum orci commodo. Suspendisse viverra, risus non consectetur finibus, eros mi imperdiet libero, eu hendrerit mauris arcu in tortor. Praesent vel accumsan arcu. Duis aliquet sem bibendum purus vestibulum, eu varius magna egestas. Integer faucibus, ante a suscipit sodales, ex dolor laoreet dolor, in ultrices neque est ac lorem.\n" +
            "Sed rhoncus at eros quis facilisis. Mauris est tellus, vulputate vitae nibh sit amet, fringilla consequat lacus. Donec condimentum tellus in imperdiet luctus. Integer a urna a nulla placerat convallis id vitae massa. Sed volutpat dapibus vulputate. Proin sit amet euismod diam. Etiam augue purus, egestas ac tortor tempus, accumsan malesuada nulla. Sed a ullamcorper lorem.";
   }


   static List<Integer> sortCodes() {
      return Arrays.asList(10100000,
            10100039,
            10100055,
            10100068,
            10100071,
            10101010,
            10101049,
            10101078,
            10101140,
            10101212,
            10101238,
            10101270,
            10101339,
            10101371,
            10101397,
            10101401,
            10101469,
            10101528,
            10101599,
            10101674,
            10101704,
            10200003,
            10200016,
            10200029,
            10200032,
            10200045,
            10200058,
            10200061,
            10200074,
            10200117,
            10200120,
            10200133,
            10200146,
            10200159,
            10200162,
            10200175,
            10200188,
            10200191,
            10200205,
            10200218,
            10200221,
            10200234,
            10200247,
            10200250,
            10201013,
            10201026,
            10201042,
            10201055,
            10201068,
            10201097,
            10201127,
            10201156,
            10201169,
            10201185,
            10201260,
            10201332,
            10201390,
            10201433,
            10201462,
            10201475,
            10201491,
            10201505,
            10201563,
            10201592,
            10201664,
            10201752,
            10201778,
            10201811,
            10201853,
            10201866,
            10201879,
            10201909,
            10201912,
            10201954,
            10201967,
            10202036,
            10202124,
            10202137,
            10202212,
            10202241,
            10202267,
            10202313,
            10202368,
            10202384,
            10202401,
            10202430,
            10202472,
            10202498,
            10202528,
            10202629,
            10202645,
            10202674,
            10202733,
            10202746,
            10202762,
            10202791,
            10202821,
            10202847,
            10202892,
            10202906,
            10202964,
            10202980,
            10203017,
            10203088,
            10203121,
            10203147,
            10203150,
            10203176,
            10203206,
            10203219,
            10203235,
            10203352,
            10203378,
            10203408,
            10203437,
            10203440,
            10203453,
            10203466,
            10203541,
            10203570,
            10203583,
            10203613,
            10203639,
            10203668,
            10203714,
            10203802,
            10203844,
            10203903,
            10203916,
            10203958,
            10203974,
            10204027,
            10204115,
            10204128,
            10204144,
            10204160,
            10204274,
            10204287,
            10204317,
            10204391,
            10204405,
            10204476,
            10204564,
            10204580,
            10204649,
            10204665,
            10204681,
            10204708,
            10204724,
            10204753,
            10204795,
            10204812,
            10204867,
            10204870,
            10204900,
            10204913,
            10204926,
            10204939,
            10204955,
            10204984,
            10205011,
            10205024,
            10205040,
            10205095,
            10205112,
            10205138,
            10205170,
            10205200,
            10205226,
            10205242,
            10205297,
            10205356,
            10205385,
            10205402,
            10205460,
            10205558,
            10205561,
            10205574,
            10205587,
            10205590,
            10205604,
            10205617,
            10205620,
            10205633,
            10205659,
            14400003,
            14401013,
            14401026,
            14401039,
            14401042,
            14401055,
            14401068,
            14401071,
            14401084,
            14401097,
            14401101,
            14401127,
            14401130,
            14401143,
            14401156,
            14401169,
            14401172,
            14401185,
            14401198,
            14401202,
            14401215,
            14401228,
            14401231,
            14401244,
            14401257,
            14401260,
            14401273,
            14401286,
            14401299,
            14401332,
            14401345,
            14401358,
            14401361,
            14401387,
            14401390,
            10300006,
            10300019,
            10300022,
            10300035,
            10301016,
            10301029,
            10301032,
            10301045,
            10301058,
            10301061,
            10301074,
            10301087,
            10301090,
            10301104,
            10301117,
            10301120,
            10301133,
            10301146,
            10301159,
            10301162,
            10301175,
            10301188,
            10301191,
            10301205,
            10301218,
            10301221,
            10301234,
            10301247,
            10301250,
            10301263,
            10301276,
            10301289,
            10301292,
            10301306,
            10301319,
            10301322,
            10301335,
            10301348,
            10301351,
            10301364,
            10301377,
            10301380,
            10301393,
            10301407,
            10301410,
            10301423,
            10301436,
            10301449,
            10301452,
            10301465,
            10301478,
            10301481,
            10301494,
            10301508,
            10301511,
            10301524,
            10301537,
            10301540,
            10301553,
            10301566,
            10301579,
            10301582,
            10301595,
            10301609,
            10301612,
            10301625,
            10301638,
            10301641,
            10301654,
            10301667,
            10301670,
            10301683,
            10301696,
            10301700,
            10301713,
            10301726,
            10301739,
            10301742,
            10301755,
            10301768,
            10301771,
            10301814,
            10301827,
            10301830);
   }


   static <E> E getRandomElement(List<E> list) {
      return list.get((int) (random() * list.size()));
   }
}