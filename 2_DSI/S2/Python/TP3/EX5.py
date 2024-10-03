def somme_2(nums, cible):
    indices_pairs = []

    index_map = {}

    for i in range(len(nums)):
        num = nums[i]

        difference = cible - num
        
        if difference in index_map:
            indices_pairs.append((index_map[difference], i))
        
        index_map[num] = i

    return indices_pairs

nums = input("liste : ").split()
nums = [int(num) for num in nums]

cible = int(input("cible : "))

resultats = somme_2(nums, cible)

if resultats:
    print("indices :", resultats)
else:
    print("Aucun couple d'indices trouvé.")

