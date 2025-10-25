document.getElementById("shortenBtn").addEventListener("click", async () => {
  const urlInput = document.getElementById("urlInput");
  const longUrl = urlInput.value.trim();
  const resultDiv = document.getElementById("result");

  if (!longUrl) {
    resultDiv.innerHTML = "<p style='color:red'>Please enter a valid URL</p>";
    return;
  }

  try {
    const response = await fetch(`/api/shorten?url=${encodeURIComponent(longUrl)}`, {
      method: "POST"
    });

    if (!response.ok) throw new Error("Request failed");

    const shortUrl = await response.text();

    resultDiv.innerHTML = `
      <p><b>Short URL:</b></p>
      <a href="${shortUrl}" class="short-url" target="_blank">${shortUrl}</a>
    `;
    urlInput.value = "";
  } catch (error) {
    resultDiv.innerHTML = `<p style="color:red">Error: ${error.message}</p>`;
  }
});
