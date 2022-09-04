#include <iostream>
#include "Empirical/include/emp/math/Random.hpp"

class Organism {
  public: 
  double behavior;
  Organism(double _behavior=0): behavior(_behavior) {}

  void mutate(emp::Random random) {
    behavior += random.GetRandNormal(0.0, 0.002);
  }

  Organism* reproduce(emp::Random random) {
    Organism* offspring = new Organism(behavior);
    offspring->mutate(random);
    return offspring;
  }

  
};

int main() {
  emp::Random random = *new emp::Random(1);
  emp::vector<Organism> population;
  for(int i=0; i<100; i++) {
    population.push_back(*new Organism(0.5));
    population[i].mutate(random);
  }

  for(int i=0; i<10000; i++) {
    Organism& cur_max = population[0];
    for(Organism j : population) {
      if(j.behavior > cur_max.behavior) {
        cur_max = j;
      }
    }
    Organism* new_org = cur_max.reproduce(random);
    size_t overwrite = random.GetUInt(0,100);
    population[overwrite] = *new_org;
  }


  Organism& cur_max = population[0];
  for(Organism j : population) {
    if(j.behavior > cur_max.behavior) {
      cur_max = j;
    }
  }
  std::cout << "Current max is: " << cur_max.behavior << std::endl;

  std::cout << "Size: " << population.size() << std::endl;

}