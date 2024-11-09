using Microsoft.EntityFrameworkCore;
using SoapCore;

var builder = WebApplication.CreateBuilder(args);

// Configure DbContext with your MySQL or SQL Server connection string
builder.Services.AddDbContext<ProjectManagementDbContext>(options =>
    options.UseSqlServer("Your_Connection_String"));

// Add SoapCore to the service collection
builder.Services.AddSoapCore();

// Register your MemberService for dependency injection
builder.Services.AddScoped<IMemberService, MemberService>();

var app = builder.Build();



// Enable SOAP endpoint
app.UseSoapEndpoint<IMemberService>("/MemberService", new SoapEncoderOptions());

app.Run();
