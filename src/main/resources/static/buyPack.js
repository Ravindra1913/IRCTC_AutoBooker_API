document.addEventListener("DOMContentLoaded", function () {

  const planSelect = document.getElementById("subscription_plan");
  const validitySelect = document.getElementById("plan_validity");
  const costInput = document.getElementById("cost");

  const pricing = {
    premium_captcha: {
      days3: 30,
      days7: 50
    },
    premium_payment: {
      days3: 50,
      days7: 80
    }
  };

  function updateCost() {
    const plan = planSelect.value;
    const validity = validitySelect.value;

    const cost = pricing[plan]?.[validity] || 0;
    costInput.value = cost;
  }

  planSelect.addEventListener("change", updateCost);
  validitySelect.addEventListener("change", updateCost);

  updateCost();

  // ✅ Buy Pack function
  window.buyPack = function () {

    const userId = document.getElementById("userId").value;
    const plan = planSelect.value;
    const validity = validitySelect.value;
    const cost = costInput.value;

    // Convert validity to number of days
    let daysToAdd = 0;
    if (validity === "days3") daysToAdd = 3;
    else if (validity === "days7") daysToAdd = 7;

    const buytimestamp = Date.now();
    const expirytimestamp = buytimestamp + daysToAdd * 24 * 60 * 60 * 1000;

    fetch("https://irctc-autobooker-web.onrender.com/newPack", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        userId: userId,
        subscriptionPlan: plan,
        validity: daysToAdd,
        cost: cost,
        buytimestamp: buytimestamp,
        expirytimestamp: expirytimestamp
      })
    })
    .then(res => res.json())
    .then(data => {
        if (data.status === "success") {
            alert(data.message);
        } else {
            alert("Error: " + data.message);
        }
    });
  };

});