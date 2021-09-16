package com.parsing;

import com.parsing.aminosDotBy.*;
import com.parsing.expertSportDotBy.*;
import com.parsing.fizcult.*;
import com.parsing.formullaDotBy.*;
import com.parsing.gammaDotBy.*;
import com.parsing.sportNutritionDotBy.*;
import com.parsing.sportPitanieDotCom.*;
import com.parsing.sportimeDotBy.*;
import com.parsing.vplaboutletDotBy.*;


import java.io.*;
import java.util.Arrays;


public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {

        Reader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Выберите сайт для анализа");
        System.out.println("0 - выбрать всех");
        System.out.println("1 - https://fizcult.by/");
        System.out.println("2 - https://aminos.by/");
        System.out.println("3 - https://gamma.by/");
        System.out.println("4 - https://sport-pitanie.com/");
        System.out.println("5 - https://expert-sport.by/");
        System.out.println("6 - https://sport-nutrition.by/");
        System.out.println("7 - https://formulla.by/");
        System.out.println("8 - http://sportime.by/");

        String enter = bufferedReader.readLine();

        int enterInt = Integer.parseInt(enter);




        if (enterInt == 0 || enterInt == 1){

            System.out.println("Идет парсинг fizcult.by!");
            //Fizcult
            try {
                new Protein();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Lcarnitine();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new BCAA();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoAcid();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new FutBurners();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Gainer();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Creatine();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Vitamin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Isotonic();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new PreworkoutComplexes();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Energy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SpecialDrugs();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new ForJointsAndLigaments();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Lglutamine();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new BoosterTestosteron();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportsDrinks();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportsChocolate();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new HealthyEating();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Cookies();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Superfoods();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new ShakersAndBottles();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new KinesioTaping();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportsMedicine();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Equipment();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new Inventory();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            System.out.println("Парсинг fizcult.by окончен!");

        }



        if(enterInt == 0 || enterInt == 2){
            //amino.by
            System.out.println("Идет парсинг aminos.by!");
            try {
                new AminoByProtein();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoByAmino();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoByGeynery();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoByKreatin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoByBCAA();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoByZhiroszhigateli();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoByLkarnitin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoByVitaminy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoByAksessuary();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new AminoByProchee();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            System.out.println("Парсинг aminos.by окончен!");

        }

        if (enterInt == 0 || enterInt == 3){
            //gamma.by

            System.out.println("Идет парсинг gamma.by!");

            try {
                new GammaByProtein();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByJoint();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByFatburn();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByPreworkout();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByTest();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByCreatine();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByIso();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByGainer();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByBatonchiki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByAmino();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByZdorovie();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByVitamin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

/*            try {
                new GammaBySporttovar();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }*/

            try {
                new GammaBySpecials();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new GammaByAcces();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            System.out.println("Парсинг gamma.by окончен!");

    }


        if (enterInt == 0 || enterInt == 4){
            //sport-pitanie.com

            System.out.println("Идет парсинг sport-pitanie.com!");

            try {
                new SportPitanieComProteinyi();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComGejneryi();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComBCAA();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComBatonchiki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComOmega();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComLglyuatamin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComLkarnitin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComEnergetiki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComIzotoniki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComAminokislotyi();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComKollagen();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComVitaminy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComCoenzyme();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComPredtrenirovochnyie();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComSustavov();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComSon();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComSpeczialnyie();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComSzhigateli();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieAksessuaryi();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComVegan();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComProbniki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new SportPitanieComKreatin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            System.out.println("Парсинг sport-pitanie.com окончен!");
        }

        if (enterInt == 0 || enterInt == 5){
            //expet-sport.by
            System.out.println("Идет парсинг expert-sport.by!");

            try {
                new expertSportDotByProtein();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByAksessuary();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotBySertifikaty();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByAminokisloty();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByGejnery();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByLkarnitine();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByVitaminy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByVegan();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByEnergetiki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotBySustavy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByKrasota();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByTestosteron();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByZhiroszhigateli();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByMagnezija();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByBatonchiki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByNapitki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByShejkery();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotBySousy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByGeli();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByEda();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByKreatin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new expertSportDotByIzotoniki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }


            System.out.println("Парсинг expert-sport.by окончен!");

        }



        if (enterInt == 0 || enterInt == 6) {
            //sport-nutrition.by

            System.out.println("Идет парсинг sport-nutrition.by!");

            try {
                new sportNutritionProtein();
            } catch (Exception e) {
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionGejnery();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionKreatin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionLkarnitin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionVitaminy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionTestosteron();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionSvyazok();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionEnergetiki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionZhiroszhigateli();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionBatonchiki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionNapitki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionPreparaty();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionPredtrenirovochnye();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionDolgoletie();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionNootropy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionNootropy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionOdezhda();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionInventar();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new sportNutritionAksessuary();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }


            System.out.println("Парсинг sport-nutrition.by окончен!");


        }


        if (enterInt == 0 || enterInt == 7){
            System.out.println("Идет парсинг formulla.by!");


            try {
                new FormullaByProtein();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new FormullaByProbniki();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                new FormullaByWeightloss();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByEnergy();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByCreatine();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByAmino();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByJoints();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByGainer();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByVitamins();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByHealth();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByTestosterone();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByKrasota();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByKrasota2();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByHealthyfood();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new FormullaByAccessories();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }



            System.out.println("Парсинг formulla.by окончен!");
        }

        if (enterInt == 0 || enterInt == 8) {
            //sportime.by
            System.out.println("Идет парсинг sportime.by!");

            try {
                new sportimeDotByProtein();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new sportimeDotByGeineri();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new sportimeDotByAminokisloti();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new sportimeDotByBcaa();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new sportimeDotByKreatin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new sportimeDotByVitamin();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new sportimeDotByOxid();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new sportimeDotByJirosjigateli();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }
            try {
                new sportimeDotBySnijenievesa();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }



            System.out.println("Парсинг sportime.by окончен!");
        }




            if (enterInt == 123){
            //GammaBySporttovar

            System.out.println("Идет парсинг GammaBySporttovar!");

            try {
                new PreworkoutComplexes();
            } catch (Exception e){
                System.out.println("Произошла ошибка в классе: " + Arrays.toString(e.getStackTrace()));
            }






                System.out.println("Парсинг GammaBySporttovar окончен!");
        }

        System.out.println("Парсинг окончен!");

        Thread.sleep(1000000);

    }

}
