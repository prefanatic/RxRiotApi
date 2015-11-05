package io.github.prefanatic.rxriotapi;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class SummonerApiTest {
 //   RxRiotApi api = new RxRiotApi();

    /*

    private void helloSummoner(Summoner summoner) {
        System.out.println("Hello " + summoner.getName() + " (" + summoner.getId() + ")");
    }

    @Test
    public void summonerByName() throws Exception {
        api.getSummonerApi().summonersByName("prefanatic,ackersand,hasire")
                .flatMapIterable(new Func1<Map<String, Summoner>, Iterable<Summoner>>() {
                    @Override
                    public Iterable<Summoner> call(Map<String, Summoner> stringSummonerMap) {
                        return stringSummonerMap.values();
                    }
                })
                .subscribe(new Action1<Summoner>() {
                    @Override
                    public void call(Summoner summoner) {
                        helloSummoner(summoner);
                    }
                });
    }

    @Test
    public void summonerById() throws Exception {
        api.getSummonerApi().summonersById("29149754,23881031,24934395")
                .flatMapIterable(new Func1<Map<String, Summoner>, Iterable<Summoner>>() {
                    @Override
                    public Iterable<Summoner> call(Map<String, Summoner> stringSummonerMap) {
                        return stringSummonerMap.values();
                    }
                })
                .subscribe(new Action1<Summoner>() {
                    @Override
                    public void call(Summoner summoner) {
                        helloSummoner(summoner);
                    }
                });
    }

    @Test
    public void masteriesFromSummoner() throws Exception {
        api.getSummonerApi().masteriesFromSummonerIds("29149754")
                .flatMapIterable(new Func1<Map<String, MasteryPages>, Iterable<MasteryPages>>() {
                    @Override
                    public Iterable<MasteryPages> call(Map<String, MasteryPages> stringMasteryPagesMap) {
                        return stringMasteryPagesMap.values();
                    }
                })
                .subscribe(new Action1<MasteryPages>() {
                    @Override
                    public void call(MasteryPages masteryPages) {
                        for (MasteryPage page : masteryPages.getPages())
                            System.out.println("Page name is " + page.getName());
                    }
                });
    }

    @Test
    public void summonerNamesById() throws Exception {
        api.getSummonerApi().getSummonerNamesById("29149754,23881031,24934395")
                .flatMapIterable(new Func1<Map<String, String>, Iterable<String>>() {
                    @Override
                    public Iterable<String> call(Map<String, String> stringStringMap) {
                        return stringStringMap.values();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("Found " + s);
                    }
                });
    }

    @Test
    public void runePages() throws Exception {
        api.getSummonerApi().runesFromSummonerIds("29149754")
                .flatMapIterable(new Func1<Map<String, RunePages>, Iterable<RunePages>>() {
                    @Override
                    public Iterable<RunePages> call(Map<String, RunePages> stringRunePagesMap) {
                        return stringRunePagesMap.values();
                    }
                })
                .subscribe(new Action1<RunePages>() {
                    @Override
                    public void call(RunePages runePages) {
                        for (RunePage page : runePages.getPages())
                            System.out.println("Rune page: " + page.getName());
                    }
                });
    }

    */
}