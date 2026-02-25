// ---before dependency inversion---
   // class TrendingRecommendation {
        //     public void recommend() {
        //         System.out.println("Trending Recommendation");
        //     }
        // }
        // class GenreRecommendation {
        //     public void recommend() {
        //         System.out.println("Genre Recommendation");
        //     }
        // }
        // class RecentRecommendation {
        //     public void recommend() {
        //         System.out.println("Recent Recommendation");
        //     }
        // }

    // ---after dependency inversion---
        interface Recommendation {
            void recommend();
        }       
        class TrendingRecommendation implements Recommendation {
            public void recommend() {
                System.out.println("Trending Recommendation");
            }
        }
        class GenreRecommendation implements Recommendation {
            public void recommend() {
                System.out.println("Genre Recommendation");
            }
        }
        class RecentRecommendation implements Recommendation {              
            public void recommend() {
                System.out.println("Recent Recommendation");
            }
        }  
    class RecommendationAlgorithm {
        private Recommendation recommendation;
        public  RecommendationAlgorithm(Recommendation recommendation) {
            this.recommendation = recommendation;
        }
        public void recommend() {
            recommendation.recommend();
        }
    } 

public class DependencyInversion {
    public static void main(String[] args) {
        // Recommendation recommendation = new TrendingRecommendation();
        // recommendation.recommend();
        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm(new TrendingRecommendation());
        recommendationAlgorithm.recommend();
    }
}