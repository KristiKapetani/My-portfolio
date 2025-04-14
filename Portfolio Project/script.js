document.addEventListener("DOMContentLoaded", function() {
    console.log("Portfolio Website Loaded!");

    // Simple Animation on Scroll
    window.addEventListener("scroll", function() {
        document.querySelectorAll(".fade-in").forEach((el) => {
            if (el.getBoundingClientRect().top < window.innerHeight - 50) {
                el.style.opacity = 1;
                el.style.transform = "translateY(0)";
            }
        });
    });
});
