### Author: Anya Vostinar
### Date: 2015
### Original: https://github.com/anyaevostinar/SuicidalAltruismDissertation/blob/master/bit_model/alifemain.py
### Updated to Python3 12/22/25

import random
import numpy
import sys

class Organism:
  '''A class to contain an organism'''
  def __init__(self, cellID, genome=[], parent=False, empty=False):
    self.age = 0
    self.empty = empty
    self.ID = cellID
    self.fitness = 0
    self.genome = genome
    if not self.empty:
      if len(genome):
        self.genome = genome
      elif parent:
        newGenome =[]
        for i in range(len(parent.genome)):
          newGenome.append(parent.genome[i])
        self.genome = newGenome
        self.mutate()
        parent.mutate()
        parent.fitness = 0
        parent.age = 0
      else:
        print("fail")

  def __repr__(self):
    info = "empty: " + str(self.empty) + ", ID: " + str(self.ID) + ", genome: " + str(self.genome) + ", fitness: " + str(self.fitness)
    return info

  def update(self):
    '''Updates the organism's fitness based on its age
    Returns: Boolean, true if committed program cell death'''
    if not self.empty:
      self.age += 1
      cur_gene = self.genome[self.age%len(self.genome)]
      if cur_gene == 1 or cur_gene == 0:
        self.fitness += cur_gene
        return True
      elif cur_gene == 2:
      #explode?
        if random.random() < .05:
          return False
        else:
          return True
      elif cur_gene == 3:
        return True
      

  def mutate(self):
    '''Mutates the organism's genome'''
    if random.random() < .02:
      newGenome = self.genome
      flipBit = random.randint(0, len(newGenome)-1)
      newGenome[flipBit] = random.randint(0,1)
      if random.random() < .05:
        newGenome[flipBit] = 2
      if random.random() < .05:
        newGenome[flipBit] = 3
      self.genome = newGenome
    
      
  def findNeighbors(self):
    '''Finds the organisms neighbors on a toroidal structure
    Returns: list of neighbor locations'''
    cellID = self.ID
    radius = 1
    world_x = pop_x
    world_y = pop_y
    cell_x = cellID % world_x
    cell_y = (cellID - cell_x)//world_x
    neighbor_ids = []
    for i in range(cell_x-radius, cell_x+radius+1):
      for j in range(cell_y-radius, cell_y+radius+1):
        if i<0:
          x = world_x + i
        elif i>=world_x:
          x = i-world_x
        else:
          x = i

        if j<0:
          y = world_y + j
        elif j>=world_y:
          y = j-world_y
        else:
          y = j

        neighbor_ids.append(y*world_x+x)

    return neighbor_ids
        
class Population:
  '''A class to contain the population and do stuff'''
  def __init__(self, popsize):
    self.currentUpdate = 0
    self.orgs = []
    self.pop_size = popsize
    for i in range(popsize):
      self.orgs.append(self.makeOrg())

  def makeOrg(self):
    '''A function to make a new organism randomly'''
    randomBitArray = numpy.random.randint(2, size=(100,))
    newOrg = Organism(len(self.orgs), genome=list(randomBitArray))
    return newOrg
  
  def killNonrelatedBacteria(self, neighbors, focalOrg):
    '''Neighboring bacteria that differ from focal organism are killed
    Param: list of neighbors
    Param: Organism that is exploding'''
    for neighborID in neighbors:
      neighbor = self.orgs[neighborID]
      diff = self.compareGenomes(focalOrg, neighbor)
      if diff > inclusivity:
      #kill neighbor bacterium
        self.orgs.pop(neighborID)
        self.orgs.insert(neighborID, Organism(neighborID, empty=True))


  def update(self):
    '''A function that runs a single update'''
    self.currentUpdate+=1
    for org in self.orgs:
      if not org.empty:
        explosion = org.update()
        if explosion:
          neighbors = org.findNeighbors()
          self.killNonrelatedBacteria(neighbors, org)
          #kill org
          self.orgs.pop(org.ID)
          self.orgs.insert(org.ID, Organism(org.ID, empty=True))
        elif org.fitness >= len(org.genome):
        ## Returns list of neighbor indices
          dead_neighbor = False
          neighbors = org.findNeighbors()
          for ID in neighbors:
            if self.orgs[ID].empty:
              dead_neighbor = ID
              break
          if dead_neighbor:
            position = dead_neighbor
          else:
            position = random.choice(org.findNeighbors())
          newOrg = Organism(position, parent = org)
          self.orgs.pop(position)
          self.orgs.insert(position, newOrg)
    self.explodeStats()

  def compareGenomes(self, org1, org2):
    '''Returns the number of differences between the two genomes'''
    if org1.empty or org2.empty:
      return 0
    diff = 0
    for i in range(len(org1.genome)):
      if org1.genome[i] != org2.genome[i]:
        diff += 1

    return diff

  def findBest(self, orgs_to_eval=False):
    '''Finds the best of the population or a provided subset'''
    if not orgs_to_eval:
      orgs_to_eval = self.orgs
    highest_fitness = 0
    fittest_org = False
    for org in orgs_to_eval:
      if org.fitness > highest_fitness:
        highest_fitness = org.fitness
        fittest_org = org
  
    if not fittest_org:
      print("Error! No Org selected!")
    return fittest_org

  def explodeStats(self):
    if self.currentUpdate%100 == 0:
    #how many orgs have an explode gene?
      total_explode = 0
      total_neutral = 0
      for org in population_orgs.orgs:
        if 2 in org.genome:
          total_explode +=1
        if 3 in org.genome:
          total_neutral += 1

      out_file = open("explodes.dat", 'a')
      out_file.write(str(self.currentUpdate)+ " "+ str(total_explode)+ " "+ str(total_neutral)+ "\n")
      out_file.close()

random.seed(int(sys.argv[3]))

num_updates = 600
pop_x = int(sys.argv[1])
pop_y = int(sys.argv[2])
pop_size = pop_x*pop_y
inclusivity = 0
out_file = open("explodes.dat", 'w')
out_file.write("Update Explode_Genes Neutral_Genes\n")
out_file.close()

population_orgs = Population(pop_size)
for i in range(num_updates):
  population_orgs.update()