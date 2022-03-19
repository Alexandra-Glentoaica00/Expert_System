import http.client
import json
import time

numberOfRecipes = 40;
id=1;
ingredientSet = set();
durationSet = set();
allRecipes = [];

def add_recipe(recipe):
    global id;
    if recipe.get("total_time_minutes") != None and recipe.get("total_time_minutes") != 0:
        strippedRecipe = {key:recipe[key] for key in ("name","total_time_minutes","num_servings","sections","instructions")}
        strippedRecipe["id"]=id;
        id=id+1;

        durationSet.add(int(strippedRecipe["total_time_minutes"]));

        ingredients = [];
        for index in range(len(strippedRecipe["sections"])):
            for innerIndex in range(len(strippedRecipe["sections"][index]["components"])):
                ingredients.append({
                        "raw_text":strippedRecipe.get("sections")[index]["components"][innerIndex]["raw_text"],
                        "ingredient_name":strippedRecipe.get("sections")[index]["components"][innerIndex]["ingredient"]["name"]
                    });
                ingredientSet.add(strippedRecipe.get("sections")[index]["components"][innerIndex]["ingredient"]["name"])
        strippedRecipe["ingredients"]=ingredients;
        strippedRecipe.pop("sections", None);

        for index in range(len(strippedRecipe["instructions"])):
            strippedRecipe["instructions"][index] = strippedRecipe["instructions"][index]["display_text"];

        allRecipes.append(strippedRecipe)

f = open("allResponses.json","w",encoding="utf-8")
for i in range(2):
    time.sleep(0.5)

    if i%10==1:
        print(str(i)+" requests done");

    conn = http.client.HTTPSConnection("tasty.p.rapidapi.com")

    headers = {
        'x-rapidapi-host': "tasty.p.rapidapi.com",
        'x-rapidapi-key': "8fee1783c0msh8b0eb009fb756a2p17f3eejsn477a47ab890d"
        }
        
    conn.request("GET", "/recipes/list?from="+str(40*i)+"&size=40" , headers=headers)

    res = conn.getresponse()
    data = res.read()
    datastring = data.decode("utf-8")

    f.write(datastring);
    f.write("\n\n");

    x = json.loads(datastring)
    for result in x.get("results"):
        if 'recipes' in result:
            for recipe in result.get("recipes"):
                add_recipe(recipe)
        else:
            add_recipe(result)

f.close;

g = open("mixedResponses.json","w",encoding="utf-8");
g.write(json.dumps(allRecipes));
g.close;

h = open("ingredients.json","w",encoding="utf-8");
h.write(str(sorted(ingredientSet)));
h.close;

l = open("possibleTimes.json","w",encoding="utf-8");
l.write(str(sorted(durationSet)));
l.close;

i=0;
for recipe in allRecipes:
    i=i+1;
    print(recipe.get("name"));
print(str(i)+" recipes");
print(ingredientSet);
print(str(len(ingredientSet))+" ingredients");
print(durationSet);
print(str(len(durationSet))+" durations");


